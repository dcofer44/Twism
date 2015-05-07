#!/bin/bash

curl -H 'Accept: application/vnd.twitchtv.v3+json' -X GET https://api.twitch.tv/kraken/games/top | python -m json.tool > games.json
