#!/bin/sh

git filter-branch --env-filter '

an="$GIT_AUTHOR_NAME"
am="$GIT_AUTHOR_EMAIL"
cn="$GIT_COMMITTER_NAME"
cm="$GIT_COMMITTER_EMAIL"

if [ "$GIT_COMMITTER_EMAIL" = "vince2848@msn.com" ]
then
    cn="Vincent Masse"
    cm="vincent.masse.4@ulaval.ca"
fi
if [ "$GIT_AUTHOR_EMAIL" = "vince2848@msn.com" ]
then
    an="Vincent Masse"
    am="vincent.masse.4@ulaval.ca"
fi

export GIT_AUTHOR_NAME="$an"
export GIT_AUTHOR_EMAIL="$am"
export GIT_COMMITTER_NAME="$cn"
export GIT_COMMITTER_EMAIL="$cm"
'
