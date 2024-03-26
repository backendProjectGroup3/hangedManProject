<p align="center">
  <picture>
    <source
      width="256px"
      media="(prefers-color-scheme: dark)"
      srcset="https://github.com/backendProjectGroup3/hangedManProject/assets/133643805/a3c8825e-4625-4037-adbe-9d5534017601"
    >
    <img 
      width="256px"
      src="https://github.com/backendProjectGroup3/hangedManProject/assets/133643805/e199daab-d996-46c7-86c0-1b7699ed4914"
    >
  </picture>
  <br>
  <br>
</p>

# 🎮 행맨 미니게임

[![Java](https://img.shields.io/badge/language-java-orange.svg?style=flat
)](https://www.oracle.com/java/technologies/javase-downloads.html)

익히 알고 있는 그 행맨 게임

## ❓ 소개

HangManProject는 오직 JAVA 언어로만 콘솔을 통해 출력되는 1인 플레이 게임입니다

## 🚀 시작하는 법

### IntelliJ
- Github hangedManProject 메인화면에서 초록색 "<> Code" 버튼 눌러 "Download ZIP" 후 압축 해
- IntelliJ IDEA 설치 후 실행
- 프로젝트 열기(좌측 상단 메뉴 클릭) : File/Open.../"압축 해제 한 폴더 선택"
- 프로젝트 빌드 될 때 까지 잠시 기다리기
- `src/main/java/com/hmproject/application/Application.java` 실행(Shift + F10)

## 🛠️ 요구 사항
자바 실행할 수 있는 컴퓨터

## 🕺🏻 팀원 구성
<div align="center">

| **김태영** | **도영익** | **김현수** | **안홍영** |
| :------: |  :------: | :------: | :------: |
| [<img src="https://avatars.githubusercontent.com/u/64628733?v=4" height=150 width=150> <br/> @blackdemon129](https://github.com/blackdemon129) | [<img src="https://avatars.githubusercontent.com/u/133643805?v=4" height=150 width=150> <br/> @do0ik](https://github.com/do0ik) | [<img src="https://avatars.githubusercontent.com/u/130562778?v=4" height=150 width=150> <br/> @syongsyong6035](https://github.com/syongsyong6035) | [<img src="https://avatars.githubusercontent.com/u/96677474?v=4" height=150 width=150> <br/> @inredzero](https://github.com/inredzero) |
| 🎮[Game](https://github.com/backendProjectGroup3/hangedManProject/tree/feature/mainGame) | 📝[Record](https://github.com/backendProjectGroup3/hangedManProject/tree/feature/record) | ⭐[Word](https://github.com/backendProjectGroup3/hangedManProject/tree/feature-word) | 🎨[Design](https://github.com/backendProjectGroup3/hangedManProject/tree/feature/design6) |

</div>

## 🖥️ 개발 환경
- Java
- 버전 및 이슈관리 : Github, Github Issues, Github Project
- 협업 툴 : Notion, kakaotalk

<br>

## 🍆 프로젝트 구조
```
├── .github
├── .idea
├── .build
├── gradle
└── src
     ├── main     
     │    └── java
     │          └── com.hmproject
     │                    ├── application
     │                    │      └── Application.class
     │                    ├── design
     │                    │      └── Design.class
     │                    ├── game
     │                    │      └── MainGame.class
     │                    ├── hint
     │                    │      └── HintAlgo
     │                    ├── model.records
     │                    │            ├── RecordDAO.class
     │                    │            ├── RecordTO.class
     │                    │            └── RecordView.class
     │                    ├── repository
     │                    │       └── RecordRepository.class
     │                    ├── wordselect
     │                            └── Word.class
     │
     │
     │
     ├── .gitignore
     ├── build.gradle
     ├── gradlew
     ├── README.md
     └── settings.gradle   
```
<br>
