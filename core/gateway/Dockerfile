FROM gradle:jdk17

RUN apt-get update && apt-get install -y curl inotify-tools bash && apt-get clean

# Устанавливаем step CLI
RUN curl -fsSL https://github.com/smallstep/cli/releases/download/v0.28.6/step_linux_0.28.6_amd64.tar.gz | tar -xz -C /usr/local/bin

WORKDIR /app

COPY entrypoint.sh /app/entrypoint.sh
RUN chmod +x /app/entrypoint.sh

CMD ["./entrypoint.sh"]
