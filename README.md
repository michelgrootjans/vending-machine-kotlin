# Vending Machine Kata - Kotlin
My ongoing solution to the vending machine kata. You can [find the requirements here](https://github.com/guyroyse/vending-machine-kata)

## Running Tests
To execute the tests run `./gradlew test` or run the tests from the IDE you are using (e.g. IntelliJ)

## TCR
If you feel confident, you might want to try [Kent Beck's TCR](https://medium.com/@kentbeck_7670/test-commit-revert-870bbd756864) by running `./scripts/tcr.sh`.

I introduced a continous version of tcr, inspired by these excellent articles:
* [TCR Variants (test && commit || revert)](https://medium.com/@tdeniffel/tcr-variants-test-commit-revert-bf6bd84b17d3)
* [Best open source tools for remote pair programming](https://philippe.bourgau.net/best-open-source-tools-for-remote-pair-programming/)

It currently works on mac only, and depends on the presence of `fswatch`, which you can install by running `brew install fswatch`.
Once done, just run `./scripts/refactor.sh`
