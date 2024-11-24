CREATE TABLE IF NOT EXISTS "task" (
	"id" UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	"deadline" TIMESTAMP NOT NULL,
	"priority" SMALLINT DEFAULT 0 NOT NULL,
	"state" SMALLINT DEFAULT 0 NOT NULL,
	"customer_id" UUID NOT NULL,
	"created_at" TIMESTAMP DEFAULT NOW() NOT NULL,
	"updated_at" TIMESTAMP,

	CONSTRAINT "fk_customer" FOREIGN KEY("customer_id") REFERENCES "customer"("id")
);
