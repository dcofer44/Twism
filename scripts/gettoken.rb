#!/bin/bash ruby
#This script gets the token for the top LoL streamer on Twitch

require 'net/http'
require 'json'

uri = URI("https://api.twitch.tv/kraken/streams?game=League+of+Legends&limit=1")
resp = Net::HTTP.get(uri);

parsed_json = JSON.parse(resp)

channel_name = parsed_json["streams"][0]["channel"]["name"]

token_uri = URI("https://api.twitch.tv/api/channels/#{channel_name}/access_token")
token_resp = Net::HTTP.get(token_uri)

puts JSON.pretty_generate(JSON.parse(token_resp))
