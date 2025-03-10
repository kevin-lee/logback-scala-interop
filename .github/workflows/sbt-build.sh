#!/bin/bash -e

set -x

if [ -z "$1" ]
  then
    echo "Scala version is missing. Please enter the Scala version."
    echo "sbt-build.sh 2.13.11"
    exit 1
else
  SCALA_VERSION=$1
  echo "============================================"
  echo "Build projects"
  echo "--------------------------------------------"
  echo ""
  if [[ "$CI_BRANCH" == "main" || "$CI_BRANCH" == "release" ]]
  then
    sbt -d ++${SCALA_VERSION}! clean compile packagedArtifacts
  else
    sbt -d ++${SCALA_VERSION}! clean compile package
  fi

  echo "============================================"
  echo "Building projects: Done"
  echo "============================================"
fi
