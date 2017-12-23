package com.vm.shadowsocks.ui;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseHtml {


    public static String DownLoadFromUrl(String urlStr) {

        try {
            URL url = new URL(urlStr);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setConnectTimeout(10 * 1000);

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36");

            InputStream is = conn.getInputStream();

            StringBuilder sb = new StringBuilder();

            byte[] bs = new byte[100];

            int len = 0;

            while ((len = is.read(bs)) != -1) {
                sb.append(new String(bs));
            }

            is.close();

            return sb.toString();

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public static List<String> GetServer(String html) {
        String key1 = html.split("<!-- Portfolio Section -->")[1];

        String mainkey = key1.split("<!-- Team Section -->")[0];

        int len = mainkey.split("IP Address:").length - 1;

        if (len < 0) {
            return null;
        }

        List<Server> list = new LinkedList<>();

        for (int i = 0; i < len; i++) {
            list.add(new Server());
        }

        {//IP
            Pattern r = Pattern.compile("(id=\"ip).{1,20}(</span>)", Pattern.DOTALL);

            Matcher m = r.matcher(mainkey);

            int i = 0;

            while (m.find()) {
                list.get(i++).server = m.group().split(">")[1].split("<")[0];
            }
        }

        {//Port
            Pattern r = Pattern.compile("(Port).{1,50}");

            Matcher m = r.matcher(mainkey);

            int i = 0;

            while (m.find()) {
                String[] temp = m.group().split(">");

                if (temp.length < 2) {
                    list.get(i++).server_port = "";
                } else {
                    list.get(i++).server_port = temp[1].trim();
                }
            }
        }

        {//Password
            Pattern r = Pattern.compile("(Password:).{1,50}");

            Matcher m = r.matcher(mainkey);

            int i = 0;

            while (m.find()) {
                String[] temp = m.group().split(">");

                if (temp.length < 2) {
                    list.get(i++).password = "";
                } else {
                    list.get(i++).password = temp[1].trim();
                }
            }
        }

        {//method
            Pattern r = Pattern.compile("(Method:).{1,20}(</h4>)", Pattern.DOTALL);

            Matcher m = r.matcher(mainkey);

            int i = 0;

            while (m.find()) {
                list.get(i++).method = m.group().split(":")[1].split("<")[0];
            }
        }


        List<String> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isVaild()) {
                result.add(list.get(i).toString());
            }
        }

        removeDuplicate(result);

        return result;
    }

    public static void removeDuplicate(List list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = list.size() - 1; j > i; j--) {
                if (list.get(j).equals(list.get(i))) {
                    list.remove(j);
                }
            }
        }
    }

    public static class Server {
        public String server;
        public String server_port;
        public String password;
        public String method;

        Boolean isVaild() {
            return !server.isEmpty() && !server_port.isEmpty() && !password.isEmpty() && !method.isEmpty();
        }

        @Override
        public String toString() {
            return "ss://" + method + ":" + password + "@" + server + ":" + server_port;
        }
    }

}
