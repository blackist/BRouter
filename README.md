![](http://pic.blackist.top/brouter-brouter-logo.png)
---


# Framework for Communication between  Android Modules.

BRouter is a framework for communication between modules. Route center and Action channel mapped by URL makes code traceable.

Reference To [BRouter](https://blackist.org/2018/10/23/android-modulize-router/)

### Getting Started
---

- gradle

``` gradle
compile 'org.blackist.brouter:brouter:1.0-GA'

```

- maven

``` xml
<dependency>
  <groupId>org.blackist.brouter</groupId>
  <artifactId>brouter</artifactId>
  <version>1.0-GA</version>
  <type>pom</type>
</dependency>

```

### Usage
---

Reference To [Blog](https://blackist.org/2018/10/23/android-modulize-router/)

Implement BAction channel in modules:

``` java
// implement BAction in module1
public class Module1Action extends BAction {

    public static final String NAME = "module1";

    private static final String MESSAGE_LIST = "module1/list";

    @Override
    public Object startAction(Context context, String path, Bundle param, BEvent event) {
        switch (path) {

            case MESSAGE_LIST: {
                data = new MessageFragment();
            }
            break;

            default: {
                Intent intent = new Intent(context, ModuleActivity.class);
                intent.putExtras(param);
                intent.setFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }
        return data;
    }
} 

```

Register the ModuleAction in the AppApplication:

``` java
// Register the Module1Action
BRouter.register(Module1Action.NAME, new Module1Action());

```

Invoke method in some module's action by sending Request to BRouter:

```
BRouterReq req = BRouterReq.build()\
	.action("module")
	.path("module1/list")
	.param(key, value)
	.param(bundle);
BRouterRes res = BRouter.push(context, req);
BLog.d(res.string());

```

BRouterRes is response of router request, it contains code, msg and data. The data in response can be Activity, Fragment and other any objects.



### Bugs and Feedback
---

For bugs, questions and discussions please use the [Github Issues](https://github.com/blackist/BRouter/issues).


# LICENSE
---

```
Copyright (c) 2018 L.L Dong

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

```