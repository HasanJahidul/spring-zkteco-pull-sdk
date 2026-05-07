# ZKTeco Pull Spring SDK

> Spring Boot SDK for ZKTeco biometric & access-control devices using **pull-based** data sync.

[![Maven Central](https://img.shields.io/maven-central/v/com.hasanjahidul/zkteco-pull-spring-sdk.svg)](https://central.sonatype.com/artifact/com.hasanjahidul/zkteco-pull-spring-sdk)
[![MvnRepository](https://badges.mvnrepository.com/badge/com.hasanjahidul/zkteco-pull-spring-sdk/badge.svg?label=MvnRepository)](https://mvnrepository.com/artifact/com.hasanjahidul/zkteco-pull-spring-sdk)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Downloads](https://img.shields.io/badge/downloads-1.1K%2F3mo-brightgreen.svg)](#adoption)
[![Companies](https://img.shields.io/badge/companies-45-orange.svg)](#adoption)

---

## Why this SDK

ZKTeco devices **do not push data** — they only respond to client requests. Existing Java options either rely on the proprietary push-mode ADMS protocol or wrap C/C++ binaries. This SDK gives you a clean, pure-Java, Spring Boot-native client that **pulls** attendance logs, user data, and device state on your schedule.

**Built for**: HRMS platforms, attendance systems, access-control integrations, ADMS replacements, multi-tenant SaaS that ingest from heterogeneous device fleets.

---

## Features

- 🔌 Pure Java — no native binaries, no JNI
- ⚡ Spring Boot auto-configuration — drop-in starter
- 🔁 Pull-based polling with configurable intervals
- 👥 User CRUD (enroll, update, delete, list)
- 📊 Attendance log retrieval with cursor / since-timestamp
- 🛡️ Session management, retry, and timeout handling
- 🧵 Thread-safe device clients
- 📦 Published to Maven Central (GPG-signed)

---

## Install

### Maven

```xml
<dependency>
  <groupId>com.hasanjahidul</groupId>
  <artifactId>zkteco-pull-spring-sdk</artifactId>
  <version>1.0.3</version>
</dependency>
```

### Gradle

```groovy
implementation 'com.hasanjahidul:zkteco-pull-spring-sdk:1.0.3'
```

---

## Quick start

```java
@Service
public class AttendanceService {

    private final ZkDeviceClient client;

    public AttendanceService(ZkDeviceClient client) {
        this.client = client;
    }

    public void syncDevice(String ip, int port) {
        client.connect(ip, port);
        List<AttendanceLog> logs = client.getAttendanceLogs();
        logs.forEach(System.out::println);
        client.disconnect();
    }
}
```

### Spring Boot config

```yaml
zkteco:
  poll-interval: 30s
  connect-timeout: 5s
  read-timeout: 10s
  devices:
    - id: door-1
      host: 192.168.1.201
      port: 4370
    - id: door-2
      host: 192.168.1.202
      port: 4370
```

---

## Adoption

Real-world usage (Sonatype Central stats, last 3 months):

| Metric | Value |
|--------|------:|
| Total downloads | **1,100+** |
| Unique sources | **128** |
| Companies | **45** |

Adopted across 45 companies in first 3 months on Maven Central.

---

## Use cases

- **HRMS / payroll**: pull daily attendance for payroll processing
- **Access control**: poll door logs into SIEM / audit pipeline
- **Multi-site sync**: aggregate device data from N branches into central SaaS
- **ADMS replacement**: replace push-mode legacy ADMS with reliable pull architecture

---

## Why pull, not push?

Push (ADMS) requires:
- Public IP or VPN to each device
- Devices initiating outbound HTTP — many corp networks block this
- Tight coupling: server must always be up when device fires

Pull avoids all three. Server polls on its own schedule, behind any firewall, with backoff and retry under your control.

---

## Roadmap

- [ ] Reactive (WebFlux) client
- [ ] Kotlin coroutines support
- [ ] Native image (GraalVM)
- [ ] Built-in metrics (Micrometer)
- [ ] Device fingerprint template management

---

## Contributing

PRs welcome. Open an issue first for non-trivial changes.

---

## License

MIT — see [LICENSE](LICENSE).

---

## Author

**Jahidul Hasan** — Backend Engineer (Java / Spring Boot)
[hasanjahidul.com](https://hasanjahidul.com) · [GitHub](https://github.com/HasanJahidul)
