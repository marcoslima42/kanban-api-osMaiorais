CREATE TABLE IF NOT EXISTS "customer" (
	"id" UUID DEFAULT gen_random_uuid() NOT NULL PRIMARY KEY,
	"login" VARCHAR(90) UNIQUE NOT NULL,
	"password" VARCHAR(90) NOT NULL,
	"created_at" TIMESTAMP DEFAULT NOW() NOT NULL,
	"updated_at" TIMESTAMP
);
