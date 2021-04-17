package com.spring.bean;

public class TestHello {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        private String name;
        private String id;
        public TestHello()
        {

        }
        public TestHello(String m_id,String m_name)
        {
            this.id=m_id;
            this.name=m_name;
        }

}
