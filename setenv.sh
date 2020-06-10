export ADMIN_USERNAME=root
export ADMIN_PASSWORD=root
export MONGO_USER=
export MONGO_PASS=
export MONGO_HOST=localhost
export MONGO_DATABASE_NAME=database
export MONGO_PORT=27017

if [ $# -eq 0 ] ; then
    export PRIMARY_KEY=
    export SECONDARY_KEY=
else
    export PRIMARY_KEY="$1"
    export SECONDARY_KEY="$1"
fi