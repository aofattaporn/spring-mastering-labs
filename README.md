# Lab: bean-component-vs-configuration

## Purpose

This lab demonstrates the **behavioral difference** between `@Configuration` and `@Component`
when defining `@Bean` methods in Spring.

The goal is to **prove by execution**, not theory, that:

- `@Configuration` classes are **proxied by Spring (CGLIB)**
- `@Bean` methods inside `@Configuration` are **intercepted**
- `@Bean` methods inside `@Component` are **plain Java method calls**
- Method-to-method invocation behaves **differently** depending on the annotation

This lab intentionally creates a scenario where the difference causes
**unexpected multiple bean instances**.

---

## Learning Objectives

After completing this lab, you should be able to:

- Explain why `@Configuration` is required for defining dependent `@Bean` methods
- Understand how Spring enforces singleton semantics using CGLIB proxies
- Identify incorrect usage of `@Component` with `@Bean`
- Reason about Spring configuration classes at **runtime**, not just syntax

---

## Folder Structure

lab/bean-component-vs-configuration/
├─ README.md
└─ src/main/java/com/example/beanlab/
├─ config/
│ ├─ ConfigStyleConfig.java // @Configuration example
│ └─ ComponentStyleConfig.java // @Component example
│
├─ domain/
│ └─ MyBean.java // simple bean for identity comparison
│
└─ runner/
└─ BeanRunner.java // prints bean instances at runtime


### Folder Description

- **config/**
    - Contains two configuration styles with identical logic
    - Demonstrates how Spring treats them differently at runtime

- **domain/**
    - Holds a minimal bean class
    - Used to compare object identity and instantiation count

- **runner/**
    - Entry point for executing the experiment
    - Fetches beans from `ApplicationContext` and prints instance references

---

## Experiment Overview

1. Define two beans that depend on each other
2. Implement the same logic using:
    - `@Configuration`
    - `@Component`
3. Invoke `@Bean` methods internally
4. Observe bean creation count and instance identity

---

## Expected Outcome

| Configuration Type | Result |
|-------------------|--------|
| `@Configuration` | Single instance (intercepted by proxy) |
| `@Component` | Multiple instances (plain method call) |

This confirms that **`@Bean` alone does not guarantee singleton behavior**.

---

## Key Takeaway

> `@Configuration` is not just a stereotype annotation.  
> It is a **contract** that enables Spring to enforce container semantics.

Misusing `@Component` for configuration classes can lead to subtle bugs
that are difficult to detect without understanding Spring internals.
