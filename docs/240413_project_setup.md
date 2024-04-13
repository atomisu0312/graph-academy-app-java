## 事前準備
1. 依存関係を一括ダウンロード
```
maven verify
```

2. application.propertiesの設定
```
cp src/main/resources/example.properties src/main/resources/application.properties
```

3. アプリケーションの実行
```
mvn compile exec:java
```