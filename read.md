
# To be Rich - Android 클리커 게임 💰

"To be Rich"는 Kotlin과 Jetpack Compose로 개발된 심플한 Android 클리커 게임입니다.

## 📱 게임 소개

화면의 금 스티커를 터치해서 돈을 벌고, 업그레이드를 통해 더 많은 돈을 효율적으로 벌 수 있는 클리커 게임입니다.

## ✨ 주요 기능

### 🎯 핵심 게임플레이
- **클릭해서 돈 벌기**: 화면 중앙의 금 스티커를 터치하여 돈을 획득
- **자동 수익**: 업그레이드를 통해 초당 자동으로 돈을 획득
- **시각적 피드백**: 클릭 시 돈 아이콘이 나타나는 애니메이션 효과

### 🛒 상점 시스템
- **클릭 수익 업그레이드**: 클릭당 획득 금액 증가
- **초당 수익 업그레이드**: 자동으로 획득되는 초당 금액 증가
- **랜덤 박스**: 다양한 가격대의 랜덤 보상 아이템
  - 100₩ → 0~199₩ 랜덤 획득
  - 1,000₩ → 0~1,999₩ 랜덤 획득
  - 10,000₩ → 0~19,999₩ 랜덤 획득

### 🎨 UI/UX
- **직관적인 인터페이스**: 현재 보유 금액, 초당 수익, 클릭당 수익을 실시간으로 표시
- **부드러운 화면 전환**: Navigation Compose를 활용한 매끄러운 화면 이동
- **스플래시 스크린**: 앱 시작 시 2초간 로딩 화면 표시

## 🛠 기술 스택

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **State Management**: StateFlow
- **Navigation**: Navigation Compose
- **Animation**: Compose Animation API

## 📁 프로젝트 구조

```
app/src/main/java/com/example/theroulettegame/
├── MainActivity.kt              # 메인 액티비티 및 네비게이션 설정
├── GameScreen.kt               # 게임 화면 (메인 클리커 화면)
├── StartScreen.kt              # 시작 화면
├── SplashScreen.kt             # 스플래시 화면
├── StoreScreen.kt              # 상점 화면
├── Components/
│   ├── MoneyInfo.kt           # 돈 정보 표시 컴포넌트
│   └── Title.kt               # 타이틀 컴포넌트
├── ViewModel/
│   └── MoneyViewModel.kt      # 게임 상태 관리 ViewModel
└── ui/theme/
    ├── Color.kt               # 색상 테마
    ├── Theme.kt               # 메테리얼 테마
    └── Type.kt                # 타이포그래피
```

## 🎮 게임 플레이 방법

1. **게임 시작**: 스플래시 화면 후 시작 화면에서 아무 곳이나 터치
2. **돈 벌기**: 화면 중앙의 금 스티커를 터치하여 돈 획득
3. **상점 이용**: 우측 상단의 "Store" 버튼을 눌러 상점에서 업그레이드 구매
4. **성장**: 업그레이드를 통해 더 효율적으로 돈을 벌어보세요!

## 📊 게임 시스템

### 업그레이드 공식
- **클릭 업그레이드**: 새로운 클릭 수익 = (현재 + 1) × 1.4, 비용은 1.8배 증가
- **초당 업그레이드**: 새로운 초당 수익 = (현재 + 1) × 1.2, 비용은 1.6배 증가

### 초기 설정
- 시작 자금: 10,000₩
- 초기 클릭 수익: 1₩
- 초기 초당 수익: 0₩
- 기본 업그레이드 비용: 10₩

## 🚀 설치 및 실행

### 요구사항
- Android Studio Arctic Fox 이상
- Android SDK 21 이상
- Kotlin 1.5 이상

### 설치 방법
1. 저장소를 클론합니다
```bash
git clone https://github.com/sanghyuk0612/theSimpleClicker.git
```

2. Android Studio에서 프로젝트를 엽니다

3. Gradle 동기화를 완료합니다

4. 에뮬레이터 또는 실제 기기에서 앱을 실행합니다

## 📱 지원 환경

- **최소 Android 버전**: API 21 (Android 5.0)
- **권장 Android 버전**: API 33+ (Android 13+)
- **화면 방향**: Portrait (세로 모드)

## 🎯 개발 정보

- **개발 소요 시간**: 1일
- **개발자**: sanghyuk0612
- **개발 목적**: Jetpack Compose 학습 및 간단한 클리커 게임 구현

## 🔮 향후 개발 계획

- [ ] 데이터 저장 기능 (SharedPreferences)
- [ ] 더 많은 업그레이드 옵션
- [ ] 도전 과제 시스템
- [ ] 사운드 효과 추가
- [ ] 다양한 테마 적용

## 📄 라이선스

이 프로젝트는 개인 학습 목적으로 제작되었습니다.

---

**게임을 즐기시고 피드백을 주세요! 💰✨**
