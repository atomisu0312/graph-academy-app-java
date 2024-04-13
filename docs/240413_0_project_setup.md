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

4. application.propertiesの編集
- https://graphacademy.neo4j.com/courses/app-java/0-setup/2-sandbox/を参照