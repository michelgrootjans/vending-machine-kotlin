#!/usr/bin/env sh

# based on Kent Becks's excellent article on TCR https://medium.com/@kentbeck_7670/test-commit-revert-870bbd756864

./scripts/test.sh || git checkout src/main