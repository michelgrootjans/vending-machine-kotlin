#!/usr/bin/env sh

#this script runs all tests on each file change
# requirement: brew install fswatch

git pull

scripts_dir="./scripts"
source_dir="./src"

fswatch -o -r "$source_dir" | xargs -n1 -I{} "$scripts_dir/tcr.sh"

