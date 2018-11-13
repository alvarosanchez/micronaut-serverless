#!/bin/sh -x

curl -H "Content-Type: application/json" -XPOST -d '{"text": "Hello from AWS Lambda"}' https://5bk9x4gi5b.execute-api.eu-west-1.amazonaws.com/default/slack-message