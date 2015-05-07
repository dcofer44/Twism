#!/bin/bash

curl -X GET https://api.twitch.tv/api/channels/peeve/access_token| python -m json.tool > token.json
