#!/bin/sh

git filter-branch --env-filter '
an="$GIT_AUTHOR_NAME"
am="$GIT_AUTHOR_EMAIL"
cn="$GIT_COMMITTER_NAME"
cm="$GIT_COMMITTER_EMAIL"
if [ "$GIT_COMMITTER_EMAIL" = "要修改的@邮箱地址.com" ]
then
    cn="runnerSnail"
    cm="gaomengjie_forever@163.com"
fi
if [ "$GIT_AUTHOR_EMAIL" = "要修改的@邮箱地址.com" ]
then
    an="runnerSnail"
    am="gaomengjie_forever@163.com"
fi
    export GIT_AUTHOR_NAME="$an"
    export GIT_AUTHOR_EMAIL="$am"
    export GIT_COMMITTER_NAME="$cn"
    export GIT_COMMITTER_EMAIL="$cm"
'