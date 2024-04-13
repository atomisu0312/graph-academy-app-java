# openjdk:17-jdk-bullseyeをベースイメージとして使用
FROM openjdk:17-jdk-bullseye

# イメージのメンテナー情報を設定
LABEL maintainer="your_email@example.com"

# 必要なパッケージをインストール
RUN apt-get update && \
    apt-get install -y maven gradle && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# ワーキングディレクトリを設定
WORKDIR /home/src