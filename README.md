# ネット掲示板アプリケーション ~ Internt-forum-application ~

## 概要
複数のクライアントが掲示板に書き込みを行うアプリケーション。TCPで通信を行い、複数のクライアントが一つのサーバー上のでやり取りを行うことができる。

## 機能&技術
* アプリケーションの各種操作(GUI/JFrame)
* サーバーとの接続(TCP通信/javaAPI)
* コメントの書き込み&サーバーへ送信(GUI/JFrame,TCP通信/javaAPI)
* コメントの読み込み&サーバーから受信(GUI/JFrame,TCP通信/javaAPI)

## デモの目次
* [起動時](#起動時(ユーザ二人の場合/左側:一番目に起動,右側:二番目に起動))
* [コメントの送信時](#コメントの送信時(左側のユーザが送信した場合))
* [ロード時](#ロード時(右側のユーザがロードした場合))
* [切断時](#切断時(左側のユーザが切断した後、右側のユーザがロードした場合))

## インストール方法
eclipseなどを利用して、top.htmlを実行してください。 </br>
`$ git clone https://github.com/C0118128/Internt-forum-application.git`

## 作者
* Ryoto

## ライセンス
This sample code is under [MIT license](https://en.wikipedia.org/wiki/MIT_License).

## デモ
### 起動時(ユーザ二人の場合/左側:一番目に起動,右側:二番目に起動)
![起動時](https://github.com/C0118128/Internt-forum-application/blob/doc/images/%E8%B5%B7%E5%8B%95%E6%99%82.png)</br>
[目次へ戻る](#デモの目次)

---

### コメントの送信時(左側のユーザが送信した場合)
![コメントの送信時](https://github.com/C0118128/Internt-forum-application/blob/doc/images/%E3%82%B3%E3%83%A1%E3%83%B3%E3%83%88%E9%80%81%E4%BF%A1%E6%99%82.png)</br>
[目次へ戻る](#デモの目次)

---

### ロード時(右側のユーザがロードした場合)
![ロード時](https://github.com/C0118128/Internt-forum-application/blob/doc/images/%E3%83%AD%E3%83%BC%E3%83%89%E6%99%82.png)</br>
[目次へ戻る](#デモの目次)

---

### 切断時(左側のユーザが切断した後、右側のユーザがロードした場合)
![切断時](https://github.com/C0118128/Internt-forum-application/blob/doc/images/%E5%88%87%E6%96%AD%E6%99%82.png)</br>
[目次へ戻る](#デモの目次)
