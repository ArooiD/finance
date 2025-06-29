FROM gradle:jdk17

RUN apt-get update
RUN apt-get install -y curl inotify-tools bash
RUN apt-get clean

WORKDIR /app

COPY ./build/libs/account-0.1-all.jar /app/app.jar
RUN chmod +x /app/app.jar
COPY ./entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

ENTRYPOINT ["sh", "/app/entrypoint.sh"]
