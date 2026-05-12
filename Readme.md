Docker starting command:
./gradlew clean bootJar &&
docker compose down -v &&
docker compose up --build &&