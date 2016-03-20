# Chinachu4J

[![Join the chat at https://gitter.im/mizofumi0411/Chinachu4J](https://badges.gitter.im/mizofumi0411/Chinachu4J.svg)](https://gitter.im/mizofumi0411/Chinachu4J?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
Wrappter of Chinachu API

## Download
###Gradle
```
repositories {
  jcenter()
}

dependencies {
  compile 'net.mizofumi:chinachu4j:0.1.0'
}
```

## How to Use
```
Chinachu4J chinachu4J = new Chinachu4J("http://hogefuga:10772/api/",new BasicAuthenticator(
  "username",
  "password"
));

Program[] programs = chinachu4J.getNowChannelSchedule();
```
