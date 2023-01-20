# wasm-quarkus

Demonstation of Wasm with java
This uses the simple calculator wasm with "add, div, sub, mul"  functions, loaded by wasmer-sdk (jni wrapper) in conjunction with
quarkus.

It Provides calculation via http GET with parameter a and b.
Sample calls are

http://localhost:8080/calc/add?a=500&b=2644
http://localhost:8080/calc/div?a=5000&b=50
http://localhost:8080/calc/sub?a=500&b=2644
http://localhost:8080/calc/mul?a=500&b=2644
