FROM node:24-alpine AS build

WORKDIR /workspace

COPY frontend/package.json frontend/package-lock.json ./frontend/
RUN npm ci --prefix frontend

COPY frontend ./frontend
RUN mkdir -p src/main/resources/static \
    && npm --prefix frontend run build

FROM nginxinc/nginx-unprivileged:1.27-alpine

COPY --from=build /workspace/src/main/resources/static/ /usr/share/nginx/html/

EXPOSE 8080
