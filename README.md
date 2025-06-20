# 🍕 Pizza Oven KMM  
*A cross-platform pizza builder app built with Kotlin Multiplatform Mobile (KMM)*  



## ✨ Features  
✅ **Shared KMM Core**:  
- `PizzaOvenViewModel` (State management)  
- `PizzaOvenUIState` (Shared business logic)  
- Koin dependency injection  

📱 **Platform UIs**:  
- **Android**: Jetpack Compose  
- **iOS**: Jetpack Compose

🔄 **Cross-Platform Components**:  
- Scrollable, centered food selection  
- Responsive layout with shared dimensions/colors  

## 🛠️ Tech Stack  
- **Kotlin Multiplatform Mobile (KMM)**  
- **Android**: Jetpack Compose, Material 3  
- **iOS**: Jetpack Compose
- **DI**: Koin  


## 🎥 Video 


https://github.com/user-attachments/assets/df67ea70-e2ff-4e68-89cb-ff3eadbf30b8





## 🚀 Getting Started  

### Prerequisites  
- Android Studio  
- Xcode 15+  
- Kotlin 1.9.20+  

### Run Locally  
```bash
# Clone and open in Android Studio  
git clone https://github.com/your-repo/pizza-oven-kmm.git  
cd pizza-oven-kmm  

# Android  
./gradlew :androidApp:assembleDebug  

# iOS (from Xcode)  
open iosApp/iosApp.xcodeproj  
