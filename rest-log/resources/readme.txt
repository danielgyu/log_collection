In order to use ChangeStream feature of Mongodb,
mongod should not be in standalone mode but in replicated mode.

Change to `single node replica set` by modifying `mongodb.conf`.
It should be located in `/etc`.

Make sure to shutdown mongo service, then refer to this guide,
`https://stackoverflow.com/questions/59571945/the-changestream-stage-is-only-supported-on-replica-sets-error-while-using-mo`

Boot up again, check the `rs(replica set)` status by rs.status().

Check out the inforation below if rs is not initiated.
`https://dba.stackexchange.com/questions/211605/node-is-not-in-primary-or-recovering-state`

Lastly, refer to the official document for watching.
`https://docs.mongodb.com/manual/reference/method/db.collection.watch/#open-a-change-stream`
However, use isClosed rather than `isExhausted`
