#!/bin/bash
set -u -e
javac Game.java View.java Controller.java Model.java Tree.java Json.java
java Game
