#!/bin/bash
cargo install miniserve
miniserve -p 9091 $(dirname $0)/src