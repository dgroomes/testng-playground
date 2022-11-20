#!/usr/bin/env bash
# Run the tests using the TestNG main method.
# Requires that the project is already built. See the README for instructions.

set -eu

# Bash trick to get the directory containing the script. See https://stackoverflow.com/a/246128
CURRENT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" &> /dev/null && pwd )"

LIBS_DIR="$CURRENT_DIR/build/install/libs"

if [[ ! -d "$LIBS_DIR" ]]; then
  echo >&2 "Expected to find the directory '$LIBS_DIR' which should contain all .jar files but did not. See the README for instructions."
  exit 1
fi

CLASSPATH_FILE="$CURRENT_DIR/build/install/classpath.txt"
# Build the classpath file by enumerating the paths to all .jar files
find "$LIBS_DIR" | tr '\n' ':' > "$CLASSPATH_FILE"

# Clear the test report directory if one existed from a previous run of the test suite.
REPORT_DIR="$CURRENT_DIR/build/test-reports"
if [ -d "$REPORT_DIR" ]; then
  rm -rf "$REPORT_DIR"
else
  mkdir -p "$REPORT_DIR"
fi

java \
  --class-path "@$CLASSPATH_FILE" \
  org.testng.TestNG \
  -testjar "$LIBS_DIR/test.jar" \
  -d "$REPORT_DIR"
