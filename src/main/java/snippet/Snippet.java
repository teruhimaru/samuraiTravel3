package snippet;

public class Snippet {
	<!DOCTYPE html>
	<html xmlns:th="https://www.thymeleaf.org" xmlns:sec="https://www.thymeleaf.org/extras/spring-security">
		<head>
			<div th:replace="~{fragment :: meta}"></div>
			<div th:replace="~{fragment :: styles}"></div>
			<title>会員情報編集</title>
		</head>
		
		<body>
			<div class="moattravel-wrapper">
				<div th:replace="~{fragment :: header}"></div>
				<main>
					<div class="container pt-4 pb-5 moattravel-container">
						<div class="row justify-content-center">
							<div class="col-xl-5 col-lg-6 col-md-8">
								<nav class="my-3" style="--bs-breadcrumb-divider: '>';" aria-label="breadcrumb">
									<ol class="breadcrumb mb-0">
										<li class="breadcrumb-item"><a th:href="@{/}">ホーム</a></li>
										<li class="breadcrumb-item"><a th:href="@{/user}">会員情報</a></li>
										<li class="breadcrumb-item active" aria-current="page">会員情報編集</li>
									</ol>
								</nav>
								<h1 class="mb-4 text-center">会員情報編集</h1>
							</div>
						</div>
					</div>
				</main>
				<div th:replace="~{fragment :: footer}"></div>
			</div>
			<div th:replace="~{fragment :: scripts}"></div>
		</body>
	</html>
}

