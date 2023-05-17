# ComfyWhitelistAPI

ComfyWhitelist API is a set of Java interfaces designed for interaction with the 
[ComfyWhitelist](https://github.com/cocahonka/comfy-whitelist) Minecraft plugin.
It allows developers to interact with the ComfyWhitelist plugin and leverage its functionality in their own plugins.

## Features

- **Storage Interface**: Provides an abstraction for accessing and manipulating whitelist data.
- **WhitelistManager Interface**: Provides the current state of the whitelist and methods to manage the state of them.
- **ComfyWhitelistAPI Interface**: Facilitates access to `WhitelistManager` and `Storage`.

## Usage

Before using this API, ensure you have downloaded the [ComfyWhitelist](https://github.com/cocahonka/comfy-whitelist) 
plugin and placed it in the plugins folder on your server. Next, add the necessary dependencies to your plugin. 
Examples for different build tools will be provided:

<details><summary><h3>Kotlin DSL</h3></summary>

```kotlin
repositories {
    maven(url = "https://jitpack.io")
}

dependencies {
    compileOnly("com.github.cocahonka:comfy-whitelist-api:1.0.0")
}
```

</details>
<details><summary><h3>Gradle</h3></summary>

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}

dependencies {
    compileOnly 'com.github.cocahonka:comfy-whitelist-api:1.0.0'
}
```

</details>
<details><summary><h3>Maven</h3></summary>

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.cocahonka</groupId>
    <artifactId>comfy-whitelist-api</artifactId>
    <version>1.0.0</version>
    <scope>provided</scope>
</dependency>
```

</details>

After adding the dependency, add the following line to the `plugin.yml`
```yaml
depend: ["ComfyWhitelist"]
```

## API Usage Example
```java
package com.example.untitled;

import com.cocahonka.comfywhitelist.api.ComfyWhitelistAPI;
import com.cocahonka.comfywhitelist.api.Storage;
import com.cocahonka.comfywhitelist.api.WhitelistManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicesManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Set;

public class Example extends JavaPlugin {

    private static ComfyWhitelistAPI whitelistApi;
    private static WhitelistManager whitelistManager;
    private static Storage whitelistStorage;

    @Override
    public void onEnable() {
        extractWhitelistApi();

        whitelistStorage.addPlayer("cocahonka");
        whitelistStorage.addPlayer("vmlakk");

        Set<String> whitelistedPlayers = whitelistStorage.getAllWhitelistedPlayers(); // cocahonka, vmlakk

        whitelistStorage.removePlayer("vmlakk");
        whitelistStorage.clear();

        whitelistStorage.isPlayerWhitelisted("cocahonka"); // False because the clear() function was called

        whitelistManager.enableWhitelist();
        whitelistManager.disableWhitelist();
        whitelistManager.isWhitelistEnabled(); // False

    }

    private void extractWhitelistApi() {
        ServicesManager servicesManager = getServer().getServicesManager();
        RegisteredServiceProvider<ComfyWhitelistAPI> provider = servicesManager.getRegistration(ComfyWhitelistAPI.class);
        
        whitelistApi = provider.getProvider();
        whitelistManager = whitelistApi.getStateManager();
        whitelistStorage = whitelistApi.getStorage();
    }
}

```

## Contributions

Contributions to ComfyWhitelistAPI are always welcome. 
Whether you want to add new features, improve documentation, or fix bugs, your contributions are greatly appreciated.

## License

ComfyWhitelistAPI is licensed under [LICENSE](LICENSE). For more information, see the LICENSE file in this repository.
