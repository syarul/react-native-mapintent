# react-native-mapintent

A React Native map intent for Android. Allows to open Android Stock Map Application.

### Installation

```bash
npm install --save react-native-mapintent
```

### Add it to your android project

* In `android/setting.gradle`

```gradle
...
include ':RNMapIntent', ':app'
project(':RNMapIntent').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-mapintent')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':RNMapIntent')
}
```

* register module (in MainActivity.java)

```java
import com.syarul.mapintent.RNMapIntentPackage;;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new MainReactPackage())
      .addPackage(new RNMapIntentPackage())              // <------ add here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Example
```javascript
var MapIntent = require('react-native-mapintent');

MapIntent.open('3.0820879','101.6364262', 'This is da place!!');
```
## License

MIT
