
# Run server
```
mvn spring-boot:run
```

# Install HTTPie
```
pip install httpie
```

# Test script
```
http http://localhost:8082/coefficients topicId="계량기1" \
values[0][key]="계수1" values[0][value]="3.01" values[0][activateFrom]="2024-03-01" \
values[1][key]="계수1" values[1][value]="4.30" values[1][activateFrom]="2024-04-30" \
values[2][key]="계수2" values[2][value]="4.30" values[2][activateFrom]="2024-04-30" \
values[3][key]="계수2" values[3][value]="5.31" values[3][activateFrom]="2024-05-31"
```

```
http PUT http://localhost:8082/coefficients/계량기1/calculate

```

