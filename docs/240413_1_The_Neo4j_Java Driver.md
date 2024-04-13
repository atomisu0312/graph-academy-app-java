## ドライバの準備
### TODO
- Neo4jのJava Driverのインストール
- コネクションの確率
- Driverインスタンスの作成
- DBとの疎通確認
##　Driverのインストール
1. pomに以下を追加
2. sandboxクラスを用意
※本プロジェクトでは、ローカルDBをコンテナで動かしているため、urlを次のように変更しておくこと
static Driver driver = GraphDatabase.driver("bolt://neo4j:7687",
    AuthTokens.basic(username, password));

3. ローカルのneo4jにアクセスし、初期ユーザ&初期パスワードを入力
- url: http://localhost:7474/
- user: neo4j
- password: neo4j
4. パスワードを変更
- user: neo4j
- passeord: letmein!
を指定

5. sandboxパッケージ内を実行し、エラーが出ないことを確認

6. testフォルダ内_01_ConnectToNeo4jTestを実行し、テストが成功することを確認

7. driverの引数について、
```java
var driver = GraphDatabase.driver(
  connectionString, // (1)
  authenticationToken, // (2)
  configuration // (3)
)
```
7.1. connectionStringは接続先のuriのようなもの、
(例：)
```
neo4j+s://${address}:${port}?{key}=${value}
```
boltは単一のDBにアクセスしたいときに使う、基本はneo4jでいいかも

7.2. AuthToken
とりあえずusernameとpasswordがあればいいかな
```java
AuthToken authenticationToken = AuthTokens.basic(username, password);
```

7.3. 追加のコンフィグ
```java
Config config = Config.builder()
        .withConnectionTimeout(30, TimeUnit.SECONDS)
        .withMaxConnectionLifetime(30, TimeUnit.MINUTES)
        .withMaxConnectionPoolSize(10)
        .withConnectionAcquisitionTimeout(20, TimeUnit.SECONDS)
        .withFetchSize(1000)
        .withDriverMetrics()
        .withLogging(Logging.console(Level.INFO))
        .build();
```