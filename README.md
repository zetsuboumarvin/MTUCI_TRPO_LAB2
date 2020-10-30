# Технологии разработки ПО
## Лабораторная работа №2: создание кластера Kubernetes и деплой приложения
### Мареев Никита, группа 3MAC2001
#### Цель лабораторной работы - создание кластера Kubernetes, разворачивание на кластере микросервиса на нескольких репликах, получение доступа к микросервису изнутри кластера и снаружи.


### deployment.yaml
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: lab2-deployment
spec:
  replicas: 10
  selector:
    matchLabels:
      app: lab2-app
  strategy:
    rollingUpdate:
      maxSurge: 1
      maxUnavailable: 1
    type: RollingUpdate
  template:
    metadata:
      labels:
        app: lab2-app
    spec:
      containers:
        - image: lab2:latest
          imagePullPolicy: Never
          name: lab2
          ports:
            - containerPort: 8080
      hostAliases:
        - ip: "192.168.99.101"
          hostnames:
            - postgres.local
```

### service.yaml
```
apiVersion: v1
kind: Service
metadata:
  name: lab2-service
spec:
  type: NodePort
  ports:
    - nodePort: 31317
      port: 8080
      protocol: TCP
      targetPort: 8080
  selector:
    app: lab2-app
```
### Скриншоты
![](https://github.com/zetsuboumarvin/MTUCI_TRPO_LAB2/blob/master/lab_resources/lab2-3.3.png)
![](https://github.com/zetsuboumarvin/MTUCI_TRPO_LAB2/blob/master/lab_resources/lab2-3.3.1.png)
![](https://github.com/zetsuboumarvin/MTUCI_TRPO_LAB2/blob/master/lab_resources/lab2-3.3.2.png)
![](https://github.com/zetsuboumarvin/MTUCI_TRPO_LAB2/blob/master/lab_resources/lab2-3.3.3.png)
### [Видео](https://github.com/zetsuboumarvin/MTUCI_TRPO_LAB2/blob/master/lab_resources/lab2.mp4)
