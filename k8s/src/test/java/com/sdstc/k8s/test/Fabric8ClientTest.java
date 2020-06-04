package com.sdstc.k8s.test;

import org.junit.Test;

import io.fabric8.kubernetes.client.Config;
import io.fabric8.kubernetes.client.ConfigBuilder;
import io.fabric8.kubernetes.client.DefaultKubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClient;

public class Fabric8ClientTest {
	String token="eyJhbGciOiJSUzI1NiIsImtpZCI6IjNpN1IwQXc0OGROY1JVbDVHWTc5cEM5d25TMlZrZU1vWER3TXN2OWR1VUkifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJrdWJlcm5ldGVzLWRhc2hib2FyZCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VjcmV0Lm5hbWUiOiJhZG1pbi11c2VyLXRva2VuLWhndGJ4Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZXJ2aWNlLWFjY291bnQubmFtZSI6ImFkbWluLXVzZXIiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC51aWQiOiJhZGFhY2IxYy02ZDQxLTRhOWUtOWJhYi02ODNmZGY3MzdhYjkiLCJzdWIiOiJzeXN0ZW06c2VydmljZWFjY291bnQ6a3ViZXJuZXRlcy1kYXNoYm9hcmQ6YWRtaW4tdXNlciJ9.Sxv6y05H53gKpPOyvDlAWzkzIL-oWWydPzlpVJfDv2pOGckLqxUE8sepkEgCvzdt150dmb-MnShlnrcjLO9lGc9mxuaARudpqb91GOOn_R8TJLo6AK0QnSGQ5jnrj9Fs-hsLIgA41WG3XMUUi-KQITu2f-Zwq2ZXvnGZQl4F9cfusVUuNKCykcc63LLq2p3iAyN5k9bPh0sx4zP51nRhPkbCouYVTGQ-JlBzZpJUr3jF4cz_rJu97IFn25NWn8VxGzn09LsKYRP0QDBG_CaSxZiXfVB2X2Rxl5TQ5irrMTPP6SeKmsPCtaJ7SaHXgMzHy0-tuDXcdrfjLMnjbGwuPw";

	@Test
	public void test() {
		Config config = new ConfigBuilder()
				.withMasterUrl("https://172.16.200.12:6443/")
				.withOauthToken(token)
				.withTrustCerts(true)
				.build();
		try (final KubernetesClient client = new DefaultKubernetesClient(config)) {
			// Do stuff with client
			String nc=client.getNamespace();
			System.out.println(nc);
			client.close();
		}
	}
}
