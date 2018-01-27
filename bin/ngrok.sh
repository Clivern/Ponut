#!/bin/bash
#
#
#
#
#  _____   ____  _   _ _    _ _______
# |  __ \ / __ \| \ | | |  | |__   __|
# | |__) | |  | |  \| | |  | |  | |
# |  ___/| |  | | . ` | |  | |  | |
# | |    | |__| | |\  | |__| |  | |
# |_|     \____/|_| \_|\____/   |_|

wget https://bin.equinox.io/c/4VmDzA7iaHb/ngrok-stable-linux-amd64.zip
apt install unzip
unzip ngrok-stable-linux-amd64.zip
rm ngrok-stable-linux-amd64.zip
./ngrok http 4567