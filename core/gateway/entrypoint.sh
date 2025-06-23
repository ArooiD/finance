#!/bin/bash

run_app() {
  echo "Запускаем приложение..."
  java -jar build/libs/gateway-0.1-all.jar &
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
if [ ! -f build/libs/gateway-0.1-all.jar ]; then
  echo "Файл jar не найден. Сначала соберите проект."
  exit 1
fi

run_app

# Следим только за файлом jar
while inotifywait -e modify build/libs/gateway-0.1-all.jar; do
  echo "Jar файл изменён, перезапускаем..."
  shutdown_app
  run_app
done

shutdown_app
