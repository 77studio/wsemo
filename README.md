For BDMP usage.

# Test steps
#### 1. launch

``` shell
mvn clean spring-boot:run
```

#### 2. browser 1: subscribe as job id 1
open http://localhost:8080/ in browser, and input '1' then click connect button.

#### 3. browser 2: subscribe as job id 2
open http://localhost:8080/ in browser, and input '2' then click connect button.

#### 4. send message to [job id 1]'s subscribes
open http://localhost:8080/testSend?id=1&msg=longjob1 in browser
browser1 will receive this message.

#### 5. send message to [job id 2]'s subscribes
open http://localhost:8080/testSend?id=2&msg=longjob2 in browser
browser2 will receive this message.

*while step 4 and 5 can be act more times.*
