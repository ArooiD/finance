FROM gradle:jdk17

RUN apt-get update && apt-get install -y curl inotify-tools bash && apt-get clean

WORKDIR /app

COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

CMD ["./entrypoint.sh"]
