#!/bin/bash

curl -H 'Accept: application/vnd.twitchtv.v3+json' -X GET https://api.twitch.tv/kraken/streams?game=League+of+Legends | python -m json.tool > lolstreams.json
