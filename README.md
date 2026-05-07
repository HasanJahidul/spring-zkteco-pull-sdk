# ZKTeco Pull Spring SDK

> Spring Boot SDK for ZKTeco biometric & access-control devices using **pull-based** data sync.

[![Maven Central](https://img.shields.io/maven-central/v/com.hasanjahidul/zkteco-pull-spring-sdk.svg)](https://central.sonatype.com/artifact/com.hasanjahidul/zkteco-pull-spring-sdk)
[![MvnRepository](https://badges.mvnrepository.com/badge/com.hasanjahidul/zkteco-pull-spring-sdk/badge.svg?label=MvnRepository)](https://mvnrepository.com/artifact/com.hasanjahidul/zkteco-pull-spring-sdk)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![CI](https://github.com/HasanJahidul/zkteco-pull-spring-sdk/actions/workflows/ci.yml/badge.svg)](https://github.com/HasanJahidul/zkteco-pull-spring-sdk/actions/workflows/ci.yml)
[![codecov](https://codecov.io/gh/HasanJahidul/zkteco-pull-spring-sdk/branch/main/graph/badge.svg)](https://codecov.io/gh/HasanJahidul/zkteco-pull-spring-sdk)
[![Downloads](https://img.shields.io/badge/downloads-2.8K%2F3mo-brightgreen.svg)](#adoption)
[![Companies](https://img.shields.io/badge/companies-50%2B-orange.svg)](#adoption)

---

## Why this SDK

A large install base of older ZKTeco devices in production today **do not support ADMS push** — they only respond to client requests over the legacy pull protocol (TCP port 4370). Existing Java options either target newer push-only devices or wrap C/C++ binaries through JNI. This SDK gives you a clean, pure-Java, Spring Boot-native client that **pulls** attendance logs, user data, and device state on your schedule, regardless of device age or firmware.

**Built for**: HRMS platforms, attendance systems, access-control integrations, mixed device fleets where firmware varies across sites, and multi-tenant SaaS that need to support legacy hardware.

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

Real-world usage (Sonatype Publisher Insights, 3-month rolling):

| Metric | Current namespace<br/>`com.hasanjahidul` | Legacy / relocated<br/>`io.github.hasanjahidul` | Combined |
|--------|---:|---:|---:|
| Downloads | 1,100 | 1,700 | **2,800** |
| Unique sources | 128 | 142 | ≤ 270 |
| Companies | 45 | 53 | ≤ 98 |

> **Note:** The SDK was first published under `io.github.hasanjahidul:zkteco-spring-sdk` and later relocated to `com.hasanjahidul:zkteco-pull-spring-sdk` for canonical groupId ownership. Both Maven coordinates resolve to the same artifact lineage. Sources and company counts are not summed due to expected overlap during migration; downloads are additive.

---

## Use cases

- **HRMS / payroll**: pull daily attendance for payroll processing
- **Access control**: poll door logs into SIEM / audit pipeline
- **Multi-site sync**: aggregate device data from N branches into central SaaS
- **ADMS replacement**: replace push-mode legacy ADMS with reliable pull architecture

---

## Why pull?

Pull (TCP port 4370) is the legacy protocol — universally supported across the entire ZKTeco device generation, including older firmware that **never received ADMS push capability**. Real-world fleets are mixed: a single deployment can span 5+ year old devices alongside newer models.

Pull also has operational advantages over push:
- **Server polls on its own schedule** — no dependency on device-initiated traffic
- **Works behind any firewall** — no public IP, no VPN, no inbound rules per device
- **Retry / backoff under server control** — predictable failure modes
- **Stateless on the device side** — restart server without losing events

This SDK lets you support legacy devices and modern ones with the same client.

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
