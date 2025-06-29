#!/bin/bash

run_app() {
  echo "Запускаем приложение..."
  java -jar /app/app.jar &
  APP_PID=$!
}

shutdown_app() {
  if ps -p $APP_PID > /dev/null; then
    echo "Останавливаем приложение..."
    kill $APP_PID
    wait $APP_PID 2>/dev/null
  fi
}

# Убедимся, что jar уже существует
echo "step 1" && ls -la /app

if [ ! -f /app/app.jar ]; then
  echo "Файл jar не найден. Сначала соберите проект."
  exit 1
fi

run_app

# Следим только за файлом jar
while inotifywait -e modify /app/app.jar; do
  echo "Jar файл изменён, перезапускаем..."
  shutdown_app
  run_app
done

shutdown_app
