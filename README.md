# shadowsocks-android-java

Last release: [Download](https://github.com/dawei101/shadowsocks-android-java/releases)


This version of shadowsocks for android is pure java version.
Beacuse of the way of implementation, some feature would not work (icmp protocol, and correct dns result under command line)

Most code is merged from [smartproxy](https://github.com/hedaode/SmartProxy) and [shadowsocks-java](https://github.com/blakey22/shadowsocks-java)
This app inherit Smartproxy's feature: tiny/low power cost/simple operation


shadowsocks settings format

```
ss://method:password@host:port
ss://base64encode(method:password@host:port)
```

And also it inherited the support of http proxy from Smartproxy , Set the url as stardand http(s) proxy format when use it. 

http proxy foramt:

```
http://(username:passsword)@host:port
```
Support methods of encryption:

```
bf-cfb
seed-cfb
aes-128-cfb
aes-192-cfb
aes-256-cfb
aes-128-ofb
aes-192-ofb
aes-256-ofb
camellia-128-cfb
camellia-192-cfb
camellia-256-cfb
chacha20
chacha20-ietf
rc4-md5
```

#### Brother version

[Shadowsocks android(Scala)](https://github.com/shadowsocks/shadowsocks-android)

Scala version is high threshold to lots of developer, so it's a better choice to choose this version.

-----------

### 关于 About

本版本为shadowsocks android版的纯java版本
因为实现原理的缘故，会牺牲掉一些功能(主要是用到icmp协议，以及在命令行下的dns解析的正确地址).

代码多整理自 [smartproxy](https://github.com/hedaode/SmartProxy) 和 [shadowsocks-java](https://github.com/blakey22/shadowsocks-java)
本shadowsocks-android的特点继承了SmartProxy的优点: 体积小,耗电低,设置保持最简单的方式
shadowsocks设置格式：
```
ss://method:password@host:port
ss://base64encode(method:password@host:port)
```

其中代码保留了SmartProxy对http代理的支持, 使用时将配置链接填写标准http代理格式即可.
http代理格式

```
http://(username:passsword)@host:port
```
支持的加密类型：

```
bf-cfb
seed-cfb
aes-128-cfb
aes-192-cfb
aes-256-cfb
aes-128-ofb
aes-192-ofb
aes-256-ofb
camellia-128-cfb
camellia-192-cfb
camellia-256-cfb
chacha20
chacha20-ietf
rc4-md5
```

### 兄弟版本 
Brother version

##### [Shadowsocks android(Scala)](https://github.com/shadowsocks/shadowsocks-android)

### 作者同系列版本 
[shadowsocks 桌面版，一份代码完美支持windows，mac osx，linux](https://github.com/dawei101/tongsheClient.shadowsocks-go)


#### LICENSE

[Apache License](./LICENSE)



