# wasm-with-quarkus

Demonstation of Wasm with java
This uses the simple calculator wasm with "add, div, sub, mul"  functions, loaded by wasmer-sdk (jni wrapper) in conjunction with
apache camel & quarkus it process  csv files with calculations in a polling intervall

## Sourcefolder:
$HOME/camel/in

Sample Sourcefile (first column is function, followed by 2 Arguments)
add,3,5
add,5,5

## Destfolder
$HOME/camel/out

Output would be (result column added)
add,3,5,8
add,5,5,10
