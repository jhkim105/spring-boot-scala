package com.example.demo.repository

import org.junit.runner.RunWith
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(classOf[SpringRunner])
@SpringBootTest
abstract class AbstractTest {

  val log: Logger = LoggerFactory.getLogger(this.getClass)

}
