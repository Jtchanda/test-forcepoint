#!/bin/bash

# This script installs the security-library JAR file into the local Maven repository.
mvn install:install-file \
  -Dfile=libs/security-library-0.0.1-SNAPSHOT.jar \
  -DgroupId=com.nmb.bancassurance \
  -DartifactId=security-library \
  -Dversion=0.0.1-SNAPSHOT \
  -Dpackaging=jar